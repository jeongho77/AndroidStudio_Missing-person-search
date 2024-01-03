# 주제 : 실종자 정보 조회 APP 

<br>

## ⭐ 프로젝트 설명 ##
경찰청 홈페이지에서 하루에 수백명씩 실종자가 생깁니다. 실종자들은 신고되어 신상과 사진, 인상착의가 올라옵니다. <br>
하지만 이런 정보들을 쉽게 접하는 사람들은 경찰을 제외하고 굉장히 드뭅니다. 그렇기에 <br>
경찰청 실종자 정보 오픈 소스를 사용하여서 신상과 사진, 인상착의가 나온 정보들을 얻어 <br>
사람들이 알아보고 실종자를 찾을 수 있게끔 조금이라도 더 볼수있게끔 목적하기위해 앱을 제작하였습니다. <br>
이 외에는 실종 예방수칙, 신고하기, firebase를 이용한 로그인과 회원가입을 구현하였습니다. <br>
                
# 프로젝트 설명 PPT                
![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/bdd1e1a6-2ec2-4068-81ae-97ed9fe9d809)

![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/56c7fb40-9d12-4646-b8f7-bde76504a7a3)


# 메인 액티비티
사진은 모자이크 처리하였습니다.


 ![image](https://github.com/jeongho77/android_FinalPjt/assets/115057094/4c182d39-59ec-4578-a740-ff253a22cb8b)

# 중요 액티비티

# 회원 수정
![회운수정](https://github.com/jeongho77/android_FinalPjt/assets/115057094/13f28135-57f4-407e-86d1-414e0fb1399a)

# 예방수칙
![예빵수친](https://github.com/jeongho77/android_FinalPjt/assets/115057094/b0c83468-a25f-4ff6-b0aa-6810523a00ae)

# 오픈소스
경찰청 실종자 정보 조회 템플릿 https://www.safe182.go.kr/home/api/guide4.do

intent 사용법 - https://aileen93.tistory.com/4#:~:text=%5BAndroid%5D%20%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C%20%EC%95%A1%ED%8B%B0%EB%B9%84%ED%8B%B0%EA%B0%84%EC%9D%98%20%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EC%A0%84%EB%8B%AC%20%28intent%20%EC%82%AC%EC%9A%A9%EB%B2%95%29%20-,%EC%A0%84%EB%8B%AC%ED%95%98%EA%B8%B0%20...%203%203%29%20Intent%EB%A1%9C%20%EC%A0%84%EB%8B%AC%EB%B0%9B%EC%9D%80%20%EA%B0%9D%EC%B2%B4%20%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0

파이어베이스 사용법
https://richwind.co.kr/83#:~:text=1%201.%20firebase%20%EA%B0%80%EC%9E%85%20https%3A%2F%2Fconsole.firebase.google.com%20%EC%9C%BC%EB%A1%9C%20%EB%B0%A9%EB%AC%B8%ED%95%98%EC%85%94%EC%84%9C%20firebase,%EC%95%B1%20%EC%A0%91%EC%86%8D%20%EB%B0%8F%20%EC%97%B0%EB%8F%99%20%EA%B2%B0%EA%B3%BC%20%ED%99%95%EC%9D%B8%20%ED%95%98%EA%B8%B0%20

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



