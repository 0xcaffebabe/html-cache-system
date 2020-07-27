package wang.ismy.htmlcachesystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wang.ismy.htmlcachesystem.entity.Item;
import wang.ismy.htmlcachesystem.entity.ItemHtml;

import java.util.List;

/**
 * @author MY
 * @date 2020/7/23 14:19
 */
@Mapper
@Repository
public interface ItemDao {

    /**
     * 查询全部数据
     * @return 全部item
     */
    List<Item> selectAll();

    @Select("SELECT * FROM tb_item")
    List<ItemHtml> selectAllByItemHtml();

    int insert(Item item);

    Item selectById(Long id);
}
