package fac.master.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {
	@GetMapping("/photos/{id}")
	public ResponseEntity<Resource> getImage(@PathVariable String id){
	String path="src/main/resources/static/photos/"+id+".png";
	FileSystemResource file=new FileSystemResource(path);
	if (!file.exists()) {
	return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok()
	.contentType(MediaType.IMAGE_PNG)
	.body(file);
	}

}
