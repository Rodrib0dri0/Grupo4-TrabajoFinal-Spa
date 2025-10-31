package Persistencia;

import Modelo.TratamientoMasaje;
import java.util.*;

public class Guardar {

  List<TratamientoMasaje> tratamientosMasajes = new ArrayList();

    public List<TratamientoMasaje> guardarTra() {

        tratamientosMasajes.add(new TratamientoMasaje(1,"Masaje Sueco", "Relajación", "Terapia de relajación de cuerpo completo con presión ligera a media.", 45, 8500.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(2,"Masaje de tejido profundo", "Relajación", "Para aliviar tensión muscular crónica y tratar contracturas, con presión más intensa.", 55, 10500.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(3,"Masaje con piedras calientes", "Relajación", "Utiliza piedras calientes para calmar los músculos y el sistema nervioso.", 60, 11000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(4,"Masajes especializados", "Relajación", "Incluyen técnicas como la aromaterapia, masajes para parejas o masajes prenatales.", 60, 12000.00, true));

        tratamientosMasajes.add(new TratamientoMasaje(5,"Facial básico", "Facial", "Limpieza profunda, exfoliación y mascarilla para refrescar el cutis.", 40, 7000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(6,"Faciales avanzados", "Facial", "Pueden incluir tratamientos antienvejecimiento, microdermoabrasión o hidrafaciales.", 60, 12000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(7,"Microdermoabrasión", "Facial", "Exfolia la capa superficial de la piel usando puntas de diamante o microcristales.", 50, 9500.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(8,"Radiofrecuencia", "Facial", "Usa ondas de radio para generar calor en la piel, estimulando la producción de colágeno y elastina", 45, 10000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(9,"Ultrasonido", "Facial", ": Usa ondas sonoras de alta frecuencia para limpiar la piel, penetrar activos o hacer masajes profundos.", 45, 8500.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(10,"Luz Pulsada Intensa (IPL)", "Facial", "Utilizada para fotodepilación, rejuvenecimiento de la piel y tratamiento de manchas.", 50, 14000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(11,"Vaporizador facia", "Facial", "Produce vapor para abrir los poros y limpiar la piel profundamente.", 30, 6000.00, true));

        tratamientosMasajes.add(new TratamientoMasaje(12,"Exfoliación corporal", "Corporal", "Elimina las células muertas de la piel con el uso de sales o azúcares.", 30,8000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(13,"Envolturas corporales", "Corporal", "Hidratan y desintoxican la piel con ingredientes como algas, barro o chocolate.", 50, 9000.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(14,"Hidroterapia", "Corporal", "Sesiones en saunas, jacuzzis o baños de vapor.", 60, 11500.00, true));
        tratamientosMasajes.add(new TratamientoMasaje(15,"Vacumterapia", "Corporal", "Es una succión corporal que mejora la circulación sanguínea y el drenaje linfático.", 40, 12000.00, true));
        return tratamientosMasajes;
    }
}
