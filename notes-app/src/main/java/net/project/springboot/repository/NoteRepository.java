package net.project.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.project.springboot.models.Note;
import net.project.springboot.models.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserId(int userId);
}
