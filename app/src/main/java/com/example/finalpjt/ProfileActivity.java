package com.example.finalpjt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class ProfileActivity extends AppCompatActivity {
    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    Button editProfile , turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        editProfile = findViewById(R.id.editButton);
        turn = findViewById(R.id.turn);
        showAllUserData();
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
            }
        });
    }

    public void showAllUserData() {
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");
        // 비밀번호 가리기

        String hiddenPassword = "";
        int passwordLength = passwordUser.length();
        for (int i = 0; i < passwordLength; i++) {
            hiddenPassword += "*";
        }

        titleName.setText("안녕하세요 " + nameUser + "님! 좋은하루 보내세요!");
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(hiddenPassword);

        turn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               finish();
            }
        });
    }

    public void passUserData() {
        String userUsername = profileUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                    builder.setTitle("비밀번호 확인");
                    builder.setMessage("비밀번호를 입력하세요.");

                    final EditText passwordInput = new EditText(ProfileActivity.this);
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    builder.setView(passwordInput);

                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String enteredPassword = passwordInput.getText().toString().trim();

                            if (enteredPassword.equals(passwordFromDB)) {
                                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                                intent.putExtra("name", nameFromDB);
                                intent.putExtra("email", emailFromDB);
                                intent.putExtra("username", usernameFromDB);
                                intent.putExtra("password", passwordFromDB);
                                startActivity(intent);
                            } else {
                                Toast.makeText(ProfileActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // onCancelled() 메소드 내용 추가
                Toast.makeText(ProfileActivity.this, "데이터베이스 에러: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}