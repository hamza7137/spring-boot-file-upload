package com.hamza.filemngt.controller;

import com.hamza.filemngt.ResponseData;
import com.hamza.filemngt.entity.Attachment;
import com.hamza.filemngt.service.AttachmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.saveAttachment(file);
        String downloadURL = "";
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/").path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURL, file.getContentType(), file.getSize());
    }
}
