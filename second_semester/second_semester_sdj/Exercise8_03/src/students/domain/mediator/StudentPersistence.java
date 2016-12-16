package students.domain.mediator;

import java.io.IOException;
import students.domain.model.*;

public interface StudentPersistence
{
   public StudentCollection load() throws IOException;
   public int save(StudentCollection list) throws IOException;
   public int save(Student student) throws IOException;
   public int remove(Student student) throws IOException;
   public void clearStudents() throws IOException;
   public void clearAll() throws IOException;
}
