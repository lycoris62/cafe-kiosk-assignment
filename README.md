# cafe-kiosk-assignment
> 팀스파르타의 내일배움캠프에서 진행하는 자바 개인 과제로, 자신이 원하는 가게의 키오스크를 구현하는 과제입니다.   
> 집 근처의 개인카페를 대상으로 구현했으며, 자세한 기획서는 [Wiki](https://github.com/lycoris62/cafe-kiosk-assignment/wiki)를 참고하시면 됩니다.    

## 참고 메뉴판
<img width="400" alt="카패 메뉴판" src="https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/09130298-c2f3-4a5a-9d7d-a1175bd1e0d4">

## 유스케이스 다이어그램
![자바개인과제_카페키오스크-유스케이스 다이어그램2](https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/d28d3a0b-38e8-4854-80bd-bfa68aabc511)

## 플로우 차트 
<img width="700" alt="flow_1" src="https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/e42d5783-0500-4d1c-bba6-b9c166cc6f99">



## 리뷰 이후 리팩토링 
### 디렉토리 구조 
```
├── Main.java 
└── app
    ├── CafeKioskApp.java 
    ├── domain
    │   ├── Category.java           // 카테고리 enum 
    │   ├── Item.java 
    │   ├── Menu.java
    │   └── Product.java           // 카테고리 내의 상품 enum 
    ├── menu                       // 메뉴 담당 도메인 
    │   ├── MenuController.java 
    │   └── MenuView.java
    ├── order                      // 주문 담당 도메인 
    │   ├── Cart.java
    │   ├── OrderController.java
    │   ├── OrderView.java
    │   └── SalesRecord.java
    └── util
        └── InputUtil.java
```

### 설명 
* MVC 패턴을 적용하였으며, Menu와 Order 도메인을 구부하여 도메인 내에서 컨트롤러와 뷰, 모델을 만들었습니다.    
* 컨트롤러는 해당 도메인에서 요청에 대한 처리를 뷰와 모델을 이용하여 응답합니다.     
* 뷰는 컨트롤러로부터 요청되어 모델의 데이터를 출력합니다.     
* 모델은 컨트롤러로부터 요청되어 데이터를 반환합니다.

    

## 리뷰 이전 설계 
<img width="700" alt="flow_6" src="https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/65c63138-32f6-4c04-b6f9-8c19a9740a32">

플로우 차트 도형 
* 출력 : 파랑     
* 입력 : 초록     
* 분기 : 노랑     
* 로직 : 보랑     

플로우 차트 배경 
* 빨강 : 데코레이터 패턴 & 정적 팩토리 패턴 
* 연두 : 커맨드 패턴
* 노랑 : 책임의 사슬 (어댑터) 패턴
* 그외에 싱글톤 패턴도 사용했습니다.

자세한 플로우 차트 및 설계에 대한 설명은 [여기](https://github.com/lycoris62/cafe-kiosk-assignment/wiki/%EC%84%A4%EA%B3%84%EB%8F%84)에 상세히 적혀 있습니다. 
