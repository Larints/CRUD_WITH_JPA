package ru.gb.task_handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.task_handler.model.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {


}
