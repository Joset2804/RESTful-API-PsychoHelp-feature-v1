package com.psycho.psychohelp.publication.domain.service;

import com.psycho.psychohelp.publication.domain.model.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();
    Tag create(Tag tag, Long publicationId);
}
