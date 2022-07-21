import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { FormacionComponent } from './components/formacion/formacion.component';
import { DocenciaComponent } from './components/docencia/docencia.component';
import { TrabajoComponent } from './components/trabajo/trabajo.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { interceptorProvider } from './service/interceptor-service';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { EditTrabajoComponent } from './components/trabajo/edit-trabajo.component';
import { EditDocenciaComponent } from './components/docencia/edit-docencia.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { EditFormacionComponent } from './components/formacion/edit-formacion.component';
import { EditPerfilComponent } from './components/perfil/edit-perfil.component';
import { SkillComponent } from './components/skill/skill.component';
import { EditSkillComponent } from './components/skill/edit-skill.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PerfilComponent,
    FormacionComponent,
    DocenciaComponent,
    TrabajoComponent,
    FooterComponent,
    PortfolioComponent,
    LoginComponent,
    ExperienciaComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    EditTrabajoComponent,
    EditDocenciaComponent,
    ProyectoComponent,
    EditProyectoComponent,
    EditFormacionComponent,
    EditPerfilComponent,
    SkillComponent,
    EditSkillComponent,
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule, 
  ],
  providers: [
    interceptorProvider
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
