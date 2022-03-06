package net.project.springboot.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import net.project.springboot.models.Note;
import net.project.springboot.models.User;
import net.project.springboot.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotesByUser(User user) {
        return noteRepository.findByUserId(user.getId());
    }

    public ResponseEntity<Note> updateNote(@PathVariable Integer id, @RequestBody Note updatedNote) {
        Note oldNote = noteRepository.findById(id).orElseThrow();
        oldNote.setMessage(updatedNote.getMessage());
        noteRepository.save(oldNote);
        return ResponseEntity.ok(oldNote);
    }

    public ResponseEntity<Map<String, Boolean>> deleteNote(Integer id) {
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
