package admin_edit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper {

    private Context context;

    private SQLiteDatabase dbDatabase;


    public DBHelper(Context context) {
        this.context = context;


    }

    public DBHelper OpenDB() {

        DBconnecter dbCon = new DBconnecter(context);
        dbDatabase = dbCon.getWritableDatabase();
        return this;


    }
    public boolean CreateNewCategory(CategoryClass categoryClass) {
        try {
            String query = "INSERT INTO Category (CategoryID, CategoryName) VALUES (?, ?)";
            dbDatabase.execSQL(query, new Object[]{categoryClass.getCategoryId(), categoryClass.getCategoryName()});
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean CreateNewCupcake(Cupcake_Class cupcake_class) {

        try {
            dbDatabase.execSQL("insert into Cup_Cake_Table values('" + cupcake_class.getCupCakeId() + "','" + cupcake_class.getCupCakeName() + "','" + cupcake_class.getCupCakeId() +"','"+cupcake_class.getCup_Price()+ "')");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;

        }
    }
}
