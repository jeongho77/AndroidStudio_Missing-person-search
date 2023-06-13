# Android Studio 마지막 프로젝트 앱 제작하기
# 조건 : 자유(남에게 도움이 되는 것), 공익목적

# 프로젝트 주제 : 실종자 정보 조회 APP 
프로젝트 설명 : 경찰청 홈페이지에서 하루에 수백명씩 실종자가 신고되어 신상과 사진, 인상착의가 올라옵니다.
                경찰청 자체의 오픈 소스를 사용하여서 사람들이 알아보고 실종자를 찾을 수 있게끔 목적하여 앱을 제작하였고
                이 외에는 예방수칙, 신고하기, firebase를 이용한 로그인과 회원가입을 구현하였습니다.
                
# 프로젝트 설명 PPT                
![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/bdd1e1a6-2ec2-4068-81ae-97ed9fe9d809)

![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/56c7fb40-9d12-4646-b8f7-bde76504a7a3)


# 메인 액티비티
사진은 모자이크 처리하였습니다.


 ![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/4c182d39-59ec-4578-a740-ff253a22cb8b)

# 중요 액티비티

# 회원 수정
![회운수정](https://github.com/jeongho77/android_FinalPjt/assets/115057094/13f28135-57f4-407e-86d1-414e0fb1399a)

# 실종자 검색
![SELECT](https://github.com/jeongho77/android_FinalPjt/assets/115057094/25d24ae0-7b4c-4ac0-8a52-fc260817681b)

# 예방수칙
![예빵수친](https://github.com/jeongho77/android_FinalPjt/assets/115057094/b0c83468-a25f-4ff6-b0aa-6810523a00ae)

# 오픈소스
경찰청 실종자 정보 조회 템플릿 https://www.safe182.go.kr/home/api/guide4.do
[Android] 안드로이드 액티비티간의 데이터 전달 (intent 사용법) - 1 :: Ailyn의 기술 블로그 (tistory.com) – 데이터 전달하기Firebase 사용법 - 초간단 Firebase 사용해 보기 (richwind.co.kr)-파이어베이스 사용법
[Android/Kotiln] style.xml(스타일 및 테마)를 활용하여 속성 설정하기 — yellowgreenblue (tistory.com) – 디자인 활용법
![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/ab1856cd-21e5-4f26-b2f5-947d2da54c55)



# 파이어베이스 연동법
![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/c2b4303c-93ff-46c3-aab3-af29c32d7294)

   1. Firebase 프로젝트 생성 
   
   2. google-service.json파일얻기
   
   3. .json파일을 안드로이드스튜디오 프로젝트 안에 삽입 
   
   4. Firebase SDK추가
   
   5. 안드로이드와 파이어베이스 연결 확인

  build.gradle(Project : appname)

    
buildscript {
        repositories {
            google()
            jcenter()
        }
        dependencies {
            classpath 'com.android.tools.build:gradle:3.5.3'
            classpath 'com.google.gms:google-services:4.3.3'
            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files
        }
    }
    
    allprojects {
        repositories {
            google()
            jcenter()
            
        }
    }
    
    task clean(type: Delete) {
        delete rootProject.buildDir
    }
    
 

build.gradle(Module.app)

    
    apply plugin: 'com.android.application'
    apply plugin: 'com.google.gms.google-services'
    
    dependencies {
    	...
        
            implementation 'com.google.firebase:firebase-analytics:17.2.3'
            implementation 'com.google.firebase:firebase-core:17.2.3'
            implementation 'com.google.firebase:firebase-database:19.2.1'
    }
    
    넣어주고 동작 시키면 연동이 됩니다.



