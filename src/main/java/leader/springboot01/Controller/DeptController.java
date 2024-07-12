package leader.springboot01.Controller;

import leader.springboot01.Pojo.Dept;
import leader.springboot01.Pojo.Result;
import leader.springboot01.Service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门信息
     * @return
     */
    @GetMapping
    public Result list() {
        log.info("查询部门信息");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门信息：{}", id);

        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门信息
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门信息：{}", dept);

        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        log.info("根据id查询部门信息：{}", id);

        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门信息：{}", dept);

        deptService.update(dept);
        return Result.success();
    }
}
