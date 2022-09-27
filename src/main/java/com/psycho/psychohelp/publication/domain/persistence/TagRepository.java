package com.psycho.psychohelp.publication.domain.persistence;

import com.psycho.psychohelp.publication.domain.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByPublicationId(Long publicationId);
}
