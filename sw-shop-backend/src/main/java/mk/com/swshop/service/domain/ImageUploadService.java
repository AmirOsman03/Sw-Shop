package mk.com.swshop.service.domain;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageUploadService {

    private final Cloudinary cloudinary;

    public List<String> uploadProductImages(List<MultipartFile> images) throws IOException {
        List<String> uploadedUrls = new ArrayList<>();
        for (MultipartFile file : images) {
            if (file.isEmpty()) continue;
            if (file.getSize() > 5 * 1024 * 1024) throw new IllegalArgumentException("File too large");
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            uploadedUrls.add(uploadResult.get("secure_url").toString());
        }

        return uploadedUrls;
    }
}
