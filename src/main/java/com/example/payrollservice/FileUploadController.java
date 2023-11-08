package com.example.payrollservice;

import java.io.IOException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.payrollservice.exceptions.XmlProcessingException;
import com.example.payrollservice.persistence.repositories.EmployeeRepository;
import com.example.payrollservice.services.XmlProcessingService;
import com.example.payrollservice.storage.StorageService;

@Controller
public class FileUploadController {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    private final StorageService storageService;
    private final XmlProcessingService xmlProcessingService;

    public FileUploadController(StorageService storageService, EmployeeRepository repository,
            XmlProcessingService xmlProcessingService) {
        this.storageService = storageService;
        this.xmlProcessingService = xmlProcessingService;
    }

    @GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

    @GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);

		if (file == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            LOG.info("File upload attempt with an empty file.");
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        try {
            xmlProcessingService.validateAndProcess(file);
            storageService.store(file);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");
        } catch (XmlProcessingException e) {
            LOG.error("Processing error for file {}: {}", file.getOriginalFilename(), e.getMessage());
            redirectAttributes.addFlashAttribute("message",
                    "Upload failed for file " + file.getOriginalFilename() + " due to processing error.");
        }

        return "redirect:/";
    }

    // ... rest of the controller

}
