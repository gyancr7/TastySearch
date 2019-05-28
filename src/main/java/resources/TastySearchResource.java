package resources;


import lombok.extern.slf4j.Slf4j;
import request.InputQuery;
import services.TastySearchService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Slf4j
@Path("v1/")
@Produces(MediaType.APPLICATION_JSON)
public class TastySearchResource {

    private final TastySearchService tastySearchService;

    @Inject
    public TastySearchResource(TastySearchService tastySearchService) {
        this.tastySearchService = tastySearchService;
    }

    @POST
    @Path("/get-top-k-documents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTopKDocuments(@Valid InputQuery inputQuery) throws IOException {

        List<String> queryTokens = inputQuery.getQueryTokens();
        int k = inputQuery.getK();
        String filePath = inputQuery.getFilePath();
        List<String> documents = tastySearchService.topKdocuments(k, queryTokens, filePath);
        return Response.ok().entity(documents).build();
    }
}
