# cafe-kiosk-assignment
> 팀스파르타의 내일배움캠프에서 진행하는 자바 개인 과제로, 자신이 원하는 가게의 키오스크를 구현하는 과제입니다.   
> 집 근처의 개인카페를 대상으로 구현했으며, 자세한 기획서는 [Wiki](https://github.com/lycoris62/cafe-kiosk-assignment/wiki)를 참고하시면 됩니다.    
> 요구사항 정의서의 요구사항만 정해주었으며, 이후의 설계나 구현은 전적으로 본인이 했습니다. 

### 유스케이스 다이어그램
![자바개인과제_카페키오스크-유스케이스 다이어그램2](https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/d28d3a0b-38e8-4854-80bd-bfa68aabc511)

### 플로우 차트 
<img width="2242" alt="카패키오스크_플로우차트" src="https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/d84010e2-8635-4c3f-b1fd-373b5b8e3943">
<img width="2242" alt="카패키오스크_플로우차트 2 2" src="https://github.com/lycoris62/cafe-kiosk-assignment/assets/55584664/d86a7515-e852-4ea1-878a-7c1b0c7e07a7">

출력 : 파랑     
입력 : 초록     
분기 : 노랑     
로직 : 보랑     

       
* 플로우 차트를 보며 설계를 고민하던 중, 항상 입력(초록색) 전에 특정 유스케이스의 출력(파란색)이 붙이있다는 것을 확인할 수 있었습니다. 그래서 이를 묶어서, 입력을 특정 출력으로 감싸서 데코레이터 패턴으로 콘솔을 구현 하는 것이 좋겠다고 판단했습니다.    
* 또한 데코레이터에서 항상 쓰이는 입력담당 콘솔을 저장해두고 재사용하고, 특정 데코레이터를 부를 수 있도록 팩토리 패턴으로 쉽게 특정 유스케이스에 대한 입출력을 가져올 수 있도록 했습니다.    
* 또한 메인 화면에서 크게 4가지(플로우 차트 왼쪽의 마름모 4개)의 경우가 있고, 한 경우를 끝내면 다시 메인 화면으로 반복되는 구조이기 때문에, 각 경우(마름모 옆의 로직들)를 커맨드 패턴으로 나누었고, 키오스크 객체에서 메인화면에서 입력을 받으면 각 경우를 구분 후 커맨드 처리를 하도록 구현했습니다.
* 지금은 Scanner 를 입력 객체로 쓰이고 있지만, 추후에 BufferedReader나 다른 입력 방식을 사용할 수도 있기 때문에 이를 Input 인터페이스를 만들어서 나중에 갈아끼울 수 있도록 했습니다. 
