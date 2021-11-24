package dev.chalmers.photoshare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.chalmers.photoshare.domain.Photo;
import org.apache.catalina.connector.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Set;
import java.util.UUID;

@RestController
public class PhotoShareController {

//    @GetMapping("/")
//    public String defaultMapping(@RequestParam(value = "name", defaultValue = "Terrill") String name) throws JsonProcessingException {
//        Photo photo = Photo.builder()
//                .id(UUID.randomUUID().toString())
//                .name(name)
//                .description("desc_1")
//                .path("src/main/resources/static/371d091e-061c-482e-9303-57177b9c08fa.jpeg")
//                .tags(Set.of("tag1", "tag2"))
//                .build();
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        return mapper.writeValueAsString(photo);
//    }

    @PostMapping(value="/find", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] findPhotoById(@RequestBody Photo photo) {
        // TODO: prevent SQL injection and cross side scripting
        try {
            String id = photo.getId();
            InputStream in = new FileInputStream("/Users/tb0t/code/photo-share/photo-share/src/main/resources/images/" + id + ".jpeg");
            return IOUtils.toByteArray(in);
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
