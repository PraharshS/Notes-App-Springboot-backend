package net.project.springboot.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return noteRepository.findByUserId(user.getId());
    }

    public ResponseEntity<Map<String, Boolean>> deleteNote(Integer id) {
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
