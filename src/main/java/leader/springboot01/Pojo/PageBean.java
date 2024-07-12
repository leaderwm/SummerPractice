package leader.springboot01.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Long total;//总记录数

    private Object rows;//数据列表
}
