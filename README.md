# Jogo Sudoku em Java

Este foi um desafio de projeto para o bootcamp GFT Start em parceria com a dio, onde precisava-mos desenvolver um sudoku, que usava CLI args para os valores que são fixos e para os valores que se espera do usuário. Baseado na ideia inicial, adicionei um pouco de ANSI escape code, para uma melhor experiência de usuário.

# 🔧 Passo a passo básico para rodar o projeto

> [!IMPORTANT]   
> Use o Git Bash ou terminal da sua preferência que seja compatível com ANSI.

Primeiro, clone o projeto com: 
```bash
git clone https://github.com/SEU_USERNAME/sudoku-game.git
```

Depois, abra o terminal dentro da pasta src e crie a pasta "out": 
```bash
mkdir out
```
e compile direcionando os arquivos .class para "out": 
```bash
javac -d out application/*.java game/*.java enums/*.java
```
Troque para a pasta "out" com "cd out" e rode a classe Program com o seguinte comando: 
```bash
java application.Program \
"0,0;4,false" \ "1,0;7,false" \ "2,0;9,true" \ "3,0;5,false" \ "4,0;8,true" \ "5,0;6,true" \ "6,0;2,true" \ "7,0;3,false" \
"8,0;1,false" \ "0,1;1,false" \ "1,1;3,true" \ "2,1;5,false" \ "3,1;4,false" \ "4,1;7,true" \ "5,1;2,false" \ "6,1;8,false" \
"7,1;9,true" \ "8,1;6,true" \ "0,2;2,false" \ "1,2;6,true" \ "2,2;8,false" \ "3,2;9,false" \ "4,2;1,true" \ "5,2;3,false" \
"6,2;7,false" \ "7,2;4,false" \ "8,2;5,true" \ "0,3;5,true" \ "1,3;1,false" \ "2,3;3,true" \ "3,3;7,false" \ "4,3;6,false" \
"5,3;4,false" \ "6,3;9,false" \ "7,3;8,true" \ "8,3;2,false" \ "0,4;8,false" \ "1,4;9,true" \ "2,4;7,false" \ "3,4;1,true" \
"4,4;2,true" \ "5,4;5,true" \ "6,4;3,false" \ "7,4;6,true" \ "8,4;4,false" \ "0,5;6,false" \ "1,5;4,true" \ "2,5;2,false" \
"3,5;3,false" \ "4,5;9,false" \ "5,5;8,false" \ "6,5;1,true" \ "7,5;5,false" \ "8,5;7,true" \ "0,6;7,true" \ "1,6;5,false" \
"2,6;4,false" \ "3,6;2,false" \ "4,6;3,true" \ "5,6;9,false" \ "6,6;6,false" \ "7,6;1,true" \ "8,6;8,false" \ "0,7;9,true" \
"1,7;8,true" \ "2,7;1,false" \ "3,7;6,false" \ "4,7;4,true" \ "5,7;7,false" \ "6,7;5,false" \ "7,7;2,true" \ "8,7;3,false" \
"0,8;3,false" \ "1,8;2,false" \ "2,8;6,true" \ "3,8;8,true" \ "4,8;5,true" \ "5,8;1,false" \ "6,8;4,true" \ "7,8;7,false" \
"8,8;9,false"
```

# 📸Screenshots
## Menu inicial
<img width="911" height="653" alt="image" src="https://github.com/user-attachments/assets/12e9e9d7-9e07-40f2-bcfa-f77e04826cf0" />

## Alterando uma linha
<img width="732" height="623" alt="image" src="https://github.com/user-attachments/assets/86055a85-cb06-45bc-a69d-d4fc688758d2" />

## Alterando uma coluna
<img width="680" height="651" alt="image" src="https://github.com/user-attachments/assets/adacf281-2510-4d2a-aee1-32048fb9a2ef" />
