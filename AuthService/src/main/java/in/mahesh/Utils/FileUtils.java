package in.mahesh.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public static String saveFiles(String fileName , MultipartFile file) throws IOException {
		Path uploadpath = Paths.get("uploads/User-Images");
		
		if(!Files.exists(uploadpath)) {
			Files.createDirectories(uploadpath);
		}
		
		Path filePath = uploadpath.resolve(file.getOriginalFilename());
		
		Files.copy(file.getInputStream(), filePath ,StandardCopyOption.REPLACE_EXISTING);
		
		return filePath.getFileName().toString();
	}

}
