package Controllers;

import DTO.ProdutoRequestDTO;
import DTO.ProdutoResponseDTO;
import Entity.Produto;
import Services.ProdutoService;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class ProdutoController {

    @Inject
    ProdutoService service;

    @POST
    public ProdutoRequestDTO createProduct(final ProdutoRequestDTO request) {
        ProdutoRequestDTO requestDTO = service.createProduct(request);
        return requestDTO;
    }

    @PUT
    public ProdutoRequestDTO updateProduct(final ProdutoRequestDTO request) {
        ProdutoRequestDTO requestDTO = service.updateProduct(request);
        return requestDTO;
    }
}
