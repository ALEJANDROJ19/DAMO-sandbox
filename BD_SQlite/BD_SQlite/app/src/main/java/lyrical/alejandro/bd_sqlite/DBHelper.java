package lyrical.alejandro.bd_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe DBHelper.
 */
public class DBHelper extends SQLiteOpenHelper{

    /**
     * Constructora.
     * @param context: Context de l'aplicació.
     */
    public DBHelper(Context context) {
        /* Cridem a la classe super (SQLiteOpenHelper) passant-li el context, el nom de
        la base de dades i la versió d'aquesta */
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    /**
     * onCreate. Crea la base de dades en cas de que no existeixi.
     * @param db: La nostra base de dades.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Execució de sentències SQL que s'encarreguen de cridar a la classe Contract on,
        amb l'String CREATE_TABLE, es pot procedir a la creació de les taules */
        db.execSQL(DBContract.Table1.CREATE_TABLE);
        db.execSQL(DBContract.Table2.CREATE_TABLE);
        db.execSQL(DBContract.Table12.CREATE_TABLE);
    }

    /**
     * Mètode onUpgrade. Actualitza la base de dades eliminant-la i tornant-la a construir.
     * @param db: La nostra base de dades.
     * @param oldVersion: Número de la versió antiga de la bd.
     * @param newVersion: Número de la nova versió de la bd.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* Com passa amb el mètode onCreate cridem, a la classe Contract, per a
        l'eliminació de cadascuna de les taules (DELETE_TABLE és l'String que procedeix a
        l'eliminació */
        db.execSQL(DBContract.Table1.DELETE_TABLE);
        db.execSQL(DBContract.Table2.DELETE_TABLE);
        db.execSQL(DBContract.Table12.DELETE_TABLE);
         /* Una vegada eliminada la bd, cridem a onCreate per tornar-la a construir */
        onCreate(db);
    }
}
