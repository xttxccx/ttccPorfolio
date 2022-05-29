import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { FormacionComponent } from './components/formacion/formacion.component';
import { DocenciaComponent } from './components/docencia/docencia.component';
import { TrabajoComponent } from './components/trabajo/trabajo.component';
import { SkillsComponent } from './components/skills/skills.component';
import { PorcentajeComponent } from './components/porcentaje/porcentaje.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PortfolioService } from './service/portfolio.service';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PerfilComponent,
    FormacionComponent,
    DocenciaComponent,
    TrabajoComponent,
    SkillsComponent,
    PorcentajeComponent,
    ProyectosComponent,
    FooterComponent,
    PortfolioComponent,
    LoginComponent,
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule, 
  ],
  providers: [],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
