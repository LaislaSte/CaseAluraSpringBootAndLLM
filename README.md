# analise de sentimento de feedbacks - App Saude Mental AluMind

[] dockerfile with mysql

[] config resource with jpa hobernate options

[] test persistance first

[] dockerfile with ollama

[] run model with ollama on docker

[] choose llama3.1 70b for promt

[] test prompt one by one

[] something I miss was controll of tempeture, greedy, max tokens, stop sequence

[] improove .gitignore with others paths

[] Challange

- Deteccao de SPAM se o feedback nao seguir os padroes ou se uma mensagem totalmente aletoria apenas loga SPAM DETECTED
- Generativa para criar respostas baseadas
  Crie uma resposta a partir do sentimento identificado e das propostas de melhorias recebidas no feedback
  Decida entre criar um endpoint a parte ou no mesmo endpoint e diga o porque no README do projeto, dizendo razoes tecnicas que levaram a decisão
- Possível nova feature NICE TO HAVE
  RAG para ter uma base para as respostas do assistente
  Integração com dashboard analítico para futuras analises

```
Req
Feedback: "jbhhhbh"
```

```
Res
"id": 1,
" sentiment": "POS_OU_NEG_OU_INCONCLUSIVO",
"requested_features": [
{
"code": "REQUISITO FUNCIONAL",
"reason": "parte do texto que menciona a intent"
},
"code": "REQUISITO FUNCIONAL",
"reason": "parte do texto que menciona a intent"
},
]

```
