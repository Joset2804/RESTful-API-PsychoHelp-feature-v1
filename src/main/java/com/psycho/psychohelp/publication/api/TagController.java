package com.psycho.psychohelp.publication.api;

import com.psycho.psychohelp.publication.domain.service.TagService;
import com.psycho.psychohelp.publication.mapping.TagMapper;
import com.psycho.psychohelp.publication.resource.CreateTagResource;
import com.psycho.psychohelp.publication.resource.TagResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Tag")
@RestController
@RequestMapping("/api/v1/tags")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private TagMapper mapper;

    @Operation(summary = "Get Tags", description = "Get All Tags")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tags found"),
            @ApiResponse(responseCode = "400", description = "Tags not found")
    })
    @GetMapping
    public List<TagResource> getAllTags(){
        return mapper.toResource(tagService.getAll());
    }

    @Operation(summary = "Create Tag", description = "Create new tag")
    @PostMapping("/{publicationId}")
    public TagResource createTag(@PathVariable Long publicationId,@Valid @RequestBody CreateTagResource request){
        return mapper.toResource(tagService.create(mapper.toModel(request), publicationId));
    }
}
