package wang.ismy.htmlcachesystem.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author MY
 * @date 2020/7/23 14:12
 */
@Data
public class Item {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime lastGenerate;
}
