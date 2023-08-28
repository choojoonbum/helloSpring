package service.board;

import command.BoardCommand;
import model.board.Attach;
import model.board.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.board.AttachRepository;
import repository.board.BoardRepository;

import javax.persistence.Basic;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private AttachRepository attachRepository;

    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board getBoard(Long brdNo, Boolean visitIncremet) {
        Board board = getBoard(brdNo);
        if (visitIncremet && board != null) {
            board.setVisitCount(board.getVisitCount() + 1);
            boardRepository.save(board);
        }
        return board;
    }

    public Board getBoard(Long brdNo) {
        Board board = boardRepository.findByBoardNo(brdNo);
        return board;
    }

    public Board setBoard(Long brdNo, BoardCommand brdReq) {
        Board board = getBoard(brdNo);
        board.setTitle(brdReq.getTitle());
        board.setContent(brdReq.getContent());
        boardRepository.save(board);
        return board;
    }

    public void remove(Long brdNo) {
        boardRepository.deleteById(brdNo);
    }

    public List<Attach> getAttach(Board board) {
        List<Attach> attachList = attachRepository.findByBoard(board);
        return attachList.isEmpty() ? Collections.emptyList() : attachList;
    }

    public ResponseEntity<Resource> getImgResponse(String fileName, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("resources");
        String imgPath = path + File.separator + "uploadFiles" + File.separator + fileName;

        Resource resource = new FileSystemResource(imgPath);
        if (! resource.exists()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        HttpHeaders headers = new HttpHeaders();
        Path filePath = Paths.get(imgPath);
        try {
            headers.add("Content-Type", Files.probeContentType(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    public void attchFile(List<MultipartFile> multiFileList, HttpServletRequest request, Board board) {
        for (MultipartFile file : multiFileList){
            if (file.isEmpty()) return;
        }

        String path = request.getSession().getServletContext().getRealPath("resources");
        String attachDir = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String root = path + "\\" + "uploadFiles" + "\\" + attachDir;
        File fileCheck = new File(root);
        if(!fileCheck.exists()) fileCheck.mkdirs();

        List<Map<String, String>> fileList = new ArrayList<>();

        for(int i = 0; i < multiFileList.size(); i++) {
            String originFile = multiFileList.get(i).getOriginalFilename();
            String ext = originFile.substring(originFile.lastIndexOf("."));
            String changeFile = UUID.randomUUID().toString() + ext;

            Map<String, String> map = new HashMap<>();
            map.put("originFile", originFile);
            map.put("changeFile", changeFile);
            map.put("contentType", multiFileList.get(i).getContentType());
            map.put("size", String.valueOf(multiFileList.get(i).getSize()));

            fileList.add(map);
        }

        // 파일업로드
        try {
            for(int i = 0; i < multiFileList.size(); i++) {
                Map<String, String> map = fileList.get(i);
                File uploadFile = new File(root + "\\" + map.get("changeFile"));
                multiFileList.get(i).transferTo(uploadFile);
                Attach attach = Attach.builder()
                        .board(board)
                        .uploadPath(attachDir)
                        .originFile(map.get("originFile"))
                        .changeFile(map.get("changeFile"))
                        .fileType(map.get("contentType"))
                        .size(map.get("size"))
                        .createDate(LocalDateTime.now())
                        .build();
                attachRepository.save(attach);
            }
        } catch (IllegalStateException | IOException e) {
            // 실패하면 파일 삭제
            for(int i = 0; i < multiFileList.size(); i++) {
                new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
            }
        }
    }

}
