import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditDocenciaComponent } from './components/docencia/edit-docencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditFormacionComponent } from './components/formacion/edit-formacion.component';
import { LoginComponent } from './components/login/login.component';
import { EditPerfilComponent } from './components/perfil/edit-perfil.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { EditSkillComponent } from './components/skill/edit-skill.component';
import { EditTrabajoComponent } from './components/trabajo/edit-trabajo.component';

const routes: Routes = [
  {path:'portfolio', component:PortfolioComponent},
  {path:'login', component:LoginComponent},
  {path:'', redirectTo: 'portfolio', pathMatch:'full'},
  {path:'editperfil/:id', component:EditPerfilComponent},
  {path:'nuevaexp', component:NewExperienciaComponent},
  {path:'editexp/:id', component:EditExperienciaComponent},
  {path:'edittra/:id', component:EditTrabajoComponent},
  {path:'editdoc/:id', component:EditDocenciaComponent},
  {path:'editproy/:id', component:EditProyectoComponent},
  {path:'editforma/:id', component:EditFormacionComponent},
  {path:'editskill/:id', component:EditSkillComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
