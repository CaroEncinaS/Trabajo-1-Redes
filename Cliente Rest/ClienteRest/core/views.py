from django.shortcuts import render, HttpResponse
import requests
import json

# Create your views here.

def home(request):
    informacion=request.POST.get('rut')
    rut=str(informacion)
    response= requests.get('http://localhost:8080/Servicio_web_Redes/app/verificarut?rut='+rut)
    if response.status_code==200:
        print(response.content)
        return render(request, "core/home.html",{
            'rutvalido':response.text,
        })
    else:
        return render(request, "core/home.html")