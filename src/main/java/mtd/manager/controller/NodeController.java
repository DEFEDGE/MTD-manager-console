package mtd.manager.controller;

import mtd.manager.dto.NodeDTO;
import mtd.manager.service.NodeService;
import mtd.manager.vo.NodeQueryVO;
import mtd.manager.vo.NodeUpdateVO;
import mtd.manager.vo.NodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Collections;

@Validated
@RestController
@RequestMapping("/node")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @PostMapping
    public String save(@Valid @RequestBody NodeVO vO) {
        return nodeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        nodeService.delete(id);
    }

    @PutMapping
    public void update(@Valid @RequestBody NodeUpdateVO vO) {
        nodeService.update(vO);
    }

    @GetMapping("/{id}")
    public NodeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return nodeService.getById(id);
    }

    @GetMapping
    public Page<NodeDTO> query(@Valid NodeQueryVO vO) {
        return nodeService.query(vO);
    }

    @GetMapping("/all")
    public List<NodeDTO> findAll() {
        return nodeService.findAll();
    }

    @GetMapping("/cloud/all")
    public List<NodeDTO> findAllCloudNode() {
        return nodeService.findAllCloudNode();
    }

    @GetMapping("/edge/all")
    public List<NodeDTO> findAllEdgeNode() {
        return nodeService.findAllEdgeNode();
    }

    @PutMapping("/{id}")
	public void update(@Valid @RequestBody NodeUpdateVO vO, @PathVariable Long id) {
		vO.setId(id); // Set the ID to the VO
		nodeService.update(vO);
    }

    @GetMapping("/check-ip")
    public Map<String, Boolean> checkIpUniqueness(@RequestParam String ip) {
        boolean unique = nodeService.isIpUnique(ip);
        return Collections.singletonMap("unique", unique);
    }
}
