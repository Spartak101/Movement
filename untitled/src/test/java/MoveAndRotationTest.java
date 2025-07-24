import org.example.dmensionalityClasses.AngularVelocity;
import org.example.dmensionalityClasses.CornerCourse;
import org.example.dmensionalityClasses.Point;
import org.example.dmensionalityClasses.Velocity;
import org.example.move.Move;
import org.example.move.MovingObjectAdapter;
import org.example.object.Object;
import org.example.rotation.Rotation;
import org.example.rotation.RotationObjectAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест классов Move и Rotation ")
public class MoveAndRotationTest {
    private Point point = new Point(12, 5);
    private Velocity velocity = new Velocity(-7, 3);
    private CornerCourse course = new CornerCourse(0);
    private AngularVelocity angularVelocity = new AngularVelocity(5);


    @Test
    @DisplayName("Тест на движение")
    public void theMovementIsUniform() throws Exception {
        HashMap<String, Object> iniMap = new HashMap<>();
        iniMap.put("location", point);
        iniMap.put("velocity", velocity);
        Object object = new Object(iniMap);
        Point po = (Point) object.get("location");
        MovingObjectAdapter movingObjectAdapter = new MovingObjectAdapter(object);
        Move move = new Move(movingObjectAdapter);
        move.Execute();
        int coordinateOne = po.getCoordinateOne();
        int coordinateTwo = po.getCoordinateTwo();
        int expectedCoordinateOneResult = coordinateOne;
        int expectedCoordinateTwoResult = coordinateTwo;


        assertAll(
                () -> assertEquals(expectedCoordinateOneResult, 5, "Первая координата не верна"),
                () -> assertEquals(expectedCoordinateTwoResult, 8, "Вторая координата не верна")
        );
    }

    @Test
    @DisplayName("Тест на вращение")
    public void theRotationIsUniform() throws Exception {
        HashMap<String, Object> iniMap = new HashMap<>();
        iniMap.put("Course", course);
        iniMap.put("AVelocity", angularVelocity);
        Object object = new Object(iniMap);
        CornerCourse cc = (CornerCourse) object.get("Course");
        RotationObjectAdapter rotationObjectAdapter = new RotationObjectAdapter(object);
        Rotation rotation = new Rotation(rotationObjectAdapter);
        rotation.Execute();
        int ccCourse = cc.getCourse();
        int expectedCourseResult = ccCourse;

        assertEquals(expectedCourseResult, 5, "Курс не верен");
    }

    @Test
    @DisplayName("Тест на прочтение текущих координат")
    public void theCoordinatesAreCorrectTest() {
        Object object = new Object(new HashMap<String, Object>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            object.get("location");
        });
    }

    @Test
    @DisplayName("Тест на прочтение текущей скорости")
    public void theSpeedIsCorrectTest() {
        Object object = new Object(new HashMap<String, Object>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            object.get("velocity");
        });
    }

    @Test
    @DisplayName("Тест на сдвинуть объект, у которого невозможно изменить положение в пространстве")
    public void atTemptToMoveTest() {
        Object object = new Object(new HashMap<String, Object>());
        MovingObjectAdapter movingObjectAdapter = new MovingObjectAdapter(object);
        Move move = new Move(movingObjectAdapter);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            move.Execute();
        });
    }

    @Test
    @DisplayName("Тест на прочтение текущего курса")
    public void theCourseIsCorrectTest() {
        Object object = new Object(new HashMap<String, Object>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            object.get("Course");
        });
    }

    @Test
    @DisplayName("Тест на прочтение текущей угловой скорости")
    public void theAngularVelocityIsCorrectTest() {
        Object object = new Object(new HashMap<String, Object>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            object.get("AVelocity");
        });
    }

    @Test
    @DisplayName("Тест на вращать объект, у которого невозможно изменить курс")
    public void atTemptToRotateTest() {
        Object object = new Object(new HashMap<String, Object>());
        RotationObjectAdapter rotationObjectAdapter = new RotationObjectAdapter(object);
        Rotation rotation = new Rotation(rotationObjectAdapter);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rotation.Execute();
        });
    }
}
