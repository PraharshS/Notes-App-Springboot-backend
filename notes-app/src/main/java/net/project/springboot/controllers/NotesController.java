package net.project.springboot.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.project.springboot.Services.NoteService;
import net.project.springboot.models.Note;
import net.project.springboot.models.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/note")
public class NotesController {
    @Autowired
    private NoteService noteService;

    @PostMapping("get-all")
    public List<Note> getAllNotesByUser(@RequestBody User user) {
        return noteService.getAllNotesByUser(user);
    }

    @PostMapping("")
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNote(@PathVariable Integer id) {
        return noteService.deleteNote(id);
    }
}
