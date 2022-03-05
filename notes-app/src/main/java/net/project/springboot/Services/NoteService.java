package net.project.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.project.springboot.models.Note;
import net.project.springboot.models.User;
import net.project.springboot.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note) {
        noteRepository.save(note);
    }

    public List<Note> getAllNotesByUser(User user) {
        return noteRepository.findByUserId((int) user.getId());
    }
}
