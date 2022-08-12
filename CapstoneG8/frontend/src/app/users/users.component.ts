import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  list:any[]
  constructor(private api:ApiService, private toast:ToastrService,) { }

  ngOnInit(): void {
    this.loadData()
  }

  loadData(){
    this.api.listcustomers().subscribe({
      next:resp=>this.list=resp
    })
  }
  deleteuser(id:number){
    this.api.deleteUser(id).subscribe({
      next:resp=>{
        this.toast.success('User deleted')
        this.loadData()
      },
      error:err=>this.toast.error('User cannot delete')
    })
  }
}
