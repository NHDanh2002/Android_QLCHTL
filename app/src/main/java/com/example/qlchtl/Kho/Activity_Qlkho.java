package com.example.qlchtl.Kho;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlchtl.R;

import java.util.ArrayList;

import com.example.qlchtl.DanhMuc.Category;
import Database.QLCHTL_DatabaseHandler;

public class Activity_Qlkho extends AppCompatActivity {
    private ArrayList<Product> productList;
    private QLCHTL_DatabaseHandler database;
    private ProductAdapter arrayAdapter;
    private ArrayAdapter<Product> productAdapter;
    private ListView productListview;
    private Button addProductButton;
    private Button inventoryButton;
    private Button backButton;
    private ArrayAdapter<Category> adapterCategory;
    Spinner spinnerCategory;
    private EditText searchEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlkho);
        database = new QLCHTL_DatabaseHandler(this);
        productListview = findViewById(R.id.productListView);
        addProductButton = findViewById(R.id.addProductButton);
        inventoryButton = findViewById(R.id.inventoryButton);
        backButton = findViewById(R.id.backButton);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
                    add();
//                } catch (Exception e) {
//                    Toast.makeText(Activity_Qlkho.this, "Không thể mở", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Activity_Qlkho.this, Activity_nhap_xuat_kho.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(Activity_Qlkho.this, "Không thể mở", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        productListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                loadProduct();
                try{
                    // Get the product at the clicked position
                    Product product = (Product) arrayAdapter.getItem(position);
                    // Call updateproduct method with the Product as argument
                    updateProduct(product);
                }catch (Exception e){
                    Toast.makeText(Activity_Qlkho.this, "Cập nhật sản phẩm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Register listener for listView
        productListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                loadProduct();
                // Get the product at the long clicked position
                Product product = (Product) arrayAdapter.getItem(position);
                // Call delete product method with the product as argument
                deleteProduct(product);
                // Return true to indicate the event is handled
                return true;
            }
        });

        loadProduct();
    }
    public void add() {
        // Create alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set title of dialog
        builder.setTitle("Thêm sản phẩm");
        // Set layout of dialog
        View dialogView = getLayoutInflater().inflate(R.layout.activity_them_sp, null);
        builder.setView(dialogView);
        spinnerCategory = dialogView.findViewById(R.id.spinnerCategory);
        loadCategory();
        // Set positive button of dialog
        builder.setPositiveButton("Thêm sản phẩm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the dialog as an alert dialog
                AlertDialog alertDialog = (AlertDialog) dialog;
                try {
                    // Get the edit texts from the dialog
                    EditText editTextId = alertDialog.findViewById(R.id.editTextId);
                    EditText editTextName = alertDialog.findViewById(R.id.editTextName);
                    EditText editprice = alertDialog.findViewById(R.id.editTextproductPrice);
                    EditText quan = alertDialog.findViewById(R.id.editTextproductQuantity);
                    EditText edithsd = alertDialog.findViewById(R.id.editTexthsd);
                    String id = editTextId.getText().toString();
                    String name = editTextName.getText().toString();
                    Category category = (Category) spinnerCategory.getSelectedItem();
                    Double price = Double.parseDouble(editprice.getText().toString());
                    int quantity = Integer.parseInt(quan.getText().toString());
                    String hsd = edithsd.getText().toString();
                    // Create a new product with the input values
                    Product product = new Product(id, name, category, price, quantity, hsd);
                    // Add the product to the database
                    database.addProduct(product);
                    // Show a toast message
                    Toast.makeText(Activity_Qlkho.this, "Sản phẩm đã được thêm", Toast.LENGTH_SHORT).show();
                    // Reload the list of Product
                    loadProduct();
                } catch (Exception e) {
                    Toast.makeText(Activity_Qlkho.this, "Thêm sản phẩm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set negative button of dialog
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });

        // Show the dialog
        builder.show();
    }

    public void loadProduct() {
        // Get list of Product from database
        ArrayList<Product> products = database.getAllProducts();
        // Create a new instance of ProductAdapter with the list of products
        arrayAdapter = new ProductAdapter(products, this);
        // Set the array adapter to listView
        productListview.setAdapter(arrayAdapter);
    }
    public void loadCategory() {
        // Assuming that productHelper.getAllCategories() returns an ArrayList<Category>
        ArrayList<Category> categoryNames = database.getAllNameCategories();
        if (spinnerCategory != null) {
            adapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoryNames);
            adapterCategory.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            spinnerCategory.setAdapter(adapterCategory);
        } else {
            Toast.makeText(Activity_Qlkho.this, "Spinner is null", Toast.LENGTH_SHORT).show();
        }
    }
    // Update existing product
    public void updateProduct(Product product) {
        // Create alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set title of dialog
        builder.setTitle("Cập nhật sản phẩm");
        // Set layout of dialog
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        builder.setView(dialogView);
//        spinnerCategory = findViewById(R.id.spinnerCategory);
//        loadCategory();
        spinnerCategory = dialogView.findViewById(R.id.spinnerCategory);
        loadCategory();
        // Set positive button of dialog
        builder.setPositiveButton("Cập nhật sản phẩm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the dialog as an alert dialog
                AlertDialog alertDialog = (AlertDialog) dialog;
                try {
                    // Get the edit texts from the dialog
                    EditText editTextName = alertDialog.findViewById(R.id.editTextName);
                    EditText editprice = alertDialog.findViewById(R.id.editTextproductPrice);
                    EditText quan = alertDialog.findViewById(R.id.editTextproductQuantity);
                    EditText edithsd = alertDialog.findViewById(R.id.editTexthsd);
                    // Get the input values from the edit texts
                    String name = editTextName.getText().toString();
                    Category category = (Category)spinnerCategory.getSelectedItem();
                    Double price = Double.parseDouble(editprice.getText().toString());
                    int quantity = Integer.parseInt(quan.getText().toString());
                    String hsd = edithsd.getText().toString();

                    // Set the input values to the product
                    product.setProductName(name);
                    product.setProductCategory(category);
                    product.setProductPrice(price);
                    product.setProductQuantity(quantity);
                    product.sethsd(hsd);
                    // Update the product in the database
                    database.updateProduct(product);
                    // Show a toast message
                    Toast.makeText(Activity_Qlkho.this, "Sản phẩm đã được cập nhật", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Activity_Qlkho.this, "Cập nhật sản phẩm không thành công", Toast.LENGTH_SHORT).show();
                }// Reload the list of Product
                loadProduct();
            }
        });

        // Set negative button of dialog
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });

        // Set neutral button of dialog
        builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Delete the Product from the database
                database.deleteProduct(product);
                // Show a toast message
                Toast.makeText(Activity_Qlkho.this, "Sản phẩm đã bị xóa", Toast.LENGTH_SHORT).show();
                // Reload the list of Product
                loadProduct();
            }
        });

        // Create and show the dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        EditText editTextId = alertDialog.findViewById(R.id.editTextId);
        EditText editTextName = alertDialog.findViewById(R.id.editTextName);
        EditText editprice = alertDialog.findViewById(R.id.editTextproductPrice);
        EditText quan = alertDialog.findViewById(R.id.editTextproductQuantity);
        EditText edithsd = alertDialog.findViewById(R.id.editTexthsd);

        editTextName.setText(product.getProductName());

        editTextId.setText(product.getProductId());

        // Ensure that loadCategory() has completed before using spinnerCategory
        loadCategory();

        // Use spinnerCategory after it has been initialized
        spinnerCategory = alertDialog.findViewById(R.id.spinnerCategory);
        if (spinnerCategory != null) {
            spinnerCategory.setSelection(adapterCategory.getPosition(product.getProductCategory()));
        } else {
            Log.e("Activity_Qlkho", "Spinner is null");
        }

        editprice.setText(product.getProductPrice().toString());
        quan.setText(String.valueOf(product.getProductQuantity()));
        edithsd.setText(product.gethsd());

    }

    // Delete existing product
    public void deleteProduct(Product product) {
        // Create alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set title of dialog
        builder.setTitle("Xóa sản phẩm");
        // Set message of dialog
        builder.setMessage("Bạn có chắc chắn muốn xóa sản phẩm này không?");
        // Set positive button of dialog
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Delete the student from the database
                database.deleteProduct(product);
                // Show a toast message
                Toast.makeText(Activity_Qlkho.this, "Sản phẩm đã bị xóa", Toast.LENGTH_SHORT).show();
                // Reload the list of Product
                loadProduct();
            }
        });
        // Set negative button of dialog
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });
        // Create and show the dialog
        builder.create().show();
    }
}