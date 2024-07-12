package leader.springboot01.Service;

import leader.springboot01.Pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门信息
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept selectById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);
}
