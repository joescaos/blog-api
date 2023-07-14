package org.joescaos.blog.blogapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private long id;

    private String title;

    private String description;

    private String content;
}
