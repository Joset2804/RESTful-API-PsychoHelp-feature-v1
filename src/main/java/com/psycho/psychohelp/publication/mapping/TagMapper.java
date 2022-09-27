package com.psycho.psychohelp.publication.mapping;

import com.psycho.psychohelp.publication.domain.model.entity.Tag;
import com.psycho.psychohelp.publication.resource.CreateTagResource;
import com.psycho.psychohelp.publication.resource.TagResource;
import com.psycho.psychohelp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class TagMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public TagResource toResource(Tag model){
        return mapper.map(model, TagResource.class);
    }

    public List<TagResource> toResource(List<Tag> model){
        return mapper.mapList(model, TagResource.class);
    }

    public Tag toModel(CreateTagResource resource){
        return mapper.map(resource, Tag.class);
    }
}
