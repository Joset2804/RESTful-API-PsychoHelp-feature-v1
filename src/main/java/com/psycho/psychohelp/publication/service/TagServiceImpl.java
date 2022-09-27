package com.psycho.psychohelp.publication.service;

import com.psycho.psychohelp.publication.domain.model.entity.Publication;
import com.psycho.psychohelp.publication.domain.model.entity.Tag;
import com.psycho.psychohelp.publication.domain.persistence.PublicationRepository;
import com.psycho.psychohelp.publication.domain.persistence.TagRepository;
import com.psycho.psychohelp.publication.domain.service.TagService;
import com.psycho.psychohelp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final static String ENTITY = "Tags";

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag create(Tag tag, Long publicationId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(()-> new ResourceNotFoundException("Publication not found with Id", publicationId));

        tag.setPublication(publication);
        return tagRepository.save(tag);
    }
}
