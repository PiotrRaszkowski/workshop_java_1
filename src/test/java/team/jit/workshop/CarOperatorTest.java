package team.jit.workshop;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import team.jit.workshop.data.Car;
import team.jit.workshop.data.EngineState;
import team.jit.workshop.exceptions.ModelIsEmptyException;
import team.jit.workshop.services.CarOperator;
import team.jit.workshop.services.EngineManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarOperatorTest {

    private Car car = Car.builder().build();

    @Mock
    private EngineManager engineManager;

    @InjectMocks
    private CarOperator carOperator = new CarOperator(car);

//    @BeforeEach
    void beforeEach() {
        car = Car.builder().build();
//        car.setModel("default model!");

        System.out.println(car);
    }

//    @BeforeAll
    static void setupClass() {
        System.out.println("Before class!");
    }

//    @AfterEach
    void afterEach() {
        car = null;

        System.out.println("Car deleted!");
    }

//    @AfterAll
    static void afterAll() {
        System.out.println("After my test class!");
    }

    @Test
    public void engineStartWhenEngineFailureThenNotStarted() {
        //GIVEN
        Mockito.doReturn(EngineState.FAILURE).when(engineManager).getEngineState();

        //WHEN
//        car.setModel("");
        Exception exception = assertThrows(Exception.class, () -> carOperator.engineStart());

        assertEquals(ModelIsEmptyException.class, exception.getClass());

//        try {
//            car.setModel("");
//
//            carOperator.engineStart();
//        } catch (UnableToStartEngineException | NoModelProvidedException e) {
//            System.out.println("Unable to start");
//        } catch (ModelIsEmptyException e) {
//            System.out.println("model is empty!");
//        }

        //THEN
        assertFalse(car.isEngineStarted());

        Mockito.verify(engineManager, Mockito.never()).afterEngineStarted();
    }

    @Test
    public void engineStopWhenEngineStarted() {
        //GIVEN
//        car.setEngineStarted(true);

        //WHEN
        carOperator.engineStop();

        //THEN
        assertFalse(car.isEngineStarted());
    }
}