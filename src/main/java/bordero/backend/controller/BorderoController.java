package bordero.backend.controller;

import bordero.backend.model.Bordero;
import bordero.backend.model.Play;
import bordero.backend.service.BorderoService;
import bordero.dto.BorderoDTO;
import bordero.dto.PlayDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/borderos", produces = "application/json")
public class BorderoController extends CRUDRestController<BorderoDTO, Bordero> {


    public BorderoController(BorderoService service, DTOModelMapper<BorderoDTO, Bordero> mapper) {
        super(service, mapper);
    }

    @Override
    protected String url() {
        return "/borderos/";
    }

    @GetMapping(value = "", params = {"page", "size"})
    public ResponseEntity<Page<BorderoDTO>> getPage(Pageable pagReq) {
        Page<Bordero> out = getService().getPage(pagReq);
        Page<BorderoDTO> outDTO = getMapper().toDTO(out);
        return ResponseEntity.ok().body(outDTO);
    }

}
