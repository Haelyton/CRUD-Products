package Controllers;

import DTO.ProdutoRequestDTO;
import DTO.ProdutoResponseDTO;
import Entity.Produto;
import Services.ProdutoService;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/produto")
public class ProdutoController {

    @Inject
    ProdutoService service;

    @POST
    public ProdutoResponseDTO createProduct(final ProdutoRequestDTO request) {
        ProdutoResponseDTO requestDTO = service.createProduct(request);
        return requestDTO;
    }

    @PUT
    public ProdutoResponseDTO updateProduct(final ProdutoRequestDTO request) {
        ProdutoResponseDTO requestDTO = service.updateProduct(request);
        return requestDTO;
    }

    @GET
    @Path("/{id}")
    public ProdutoResponseDTO findById(@PathParam("id") final Long id) {
        ProdutoResponseDTO produto = service.findById(id);
        return produto;
    }

    @GET
    public List<ProdutoResponseDTO> findAll() {
        return service.findAll();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") final Long id) {
        service.deleteProduct(id);
        return Response.noContent().build();
    }
}
