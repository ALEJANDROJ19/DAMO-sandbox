package lyrical.alejandro.bd_sqlite;


import android.content.Context;

/**
 * Classe DBManager. Facilita la gestió de les consultes.
 */
public class DBManager {

    private DBHelper dbHelper;

    /**
     * Constructora.
     * @param context: Context de l'apliació.
     */
    DBManager(Context context) {
        this.dbHelper = new DBHelper(context);
    }
}
