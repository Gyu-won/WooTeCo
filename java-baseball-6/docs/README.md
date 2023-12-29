## 기능 명세

### 1. 1부터 9까지의 서로 다른 임의의 수 3개를 선택한다

- [Answer] 1부터 9까지의 숫자들 중 랜덤으로 숫자를 선택한다
- [Answer] 선택한 숫자가 선택된 숫자 목록에 포함되는지 확인한다

<br/>

### 2. 서로 다른 3개의 숫자를 입력한다

- [Player] 값을 입력한다
- [Guess] 입력한 값이 null인지 확인한다
- [Guess] 입력한 값이 3자리 수 인지 확인한다
- [Guess] 입력한 값이 각각 1에서 9의 범위에 포함되는지 확인한다
- [Guess] 입력한 값이 서로 다른 숫자인지 확인한다

<br/>

### 3. 입력한 숫자에 대한 결과를 계산한다

- [Result] strike를 계산한다
- [Result] ball을 계산한다
- [Result] 결과를 문자열로 반환한다

<br/>

### 4. 게임의 진행 여부를 판단한다

- [Computer] 결과가 3스트라이크인지 판단한다

<br/>

### 5. 게임이 종료되었다면 게임 재시작 여부를 확인한다

- [Player] 게임 재시작 여부를 입력한다
- [RestartFlag] 입력한 값이 null이 아닌지 확인한다
- [RestartFlag] 입력한 값이 1 또는 2 외의 값인지 확인한다
- [RestartFlag] 입력한 값이 1인지 2인지 판단한다
- [Computer] 컴퓨터는 게임을 재시작 하거나 종료한다