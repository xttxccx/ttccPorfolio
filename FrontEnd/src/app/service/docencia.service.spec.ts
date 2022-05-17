import { TestBed } from '@angular/core/testing';

import { DocenciaService } from './docencia.service';

describe('DocenciaService', () => {
  let service: DocenciaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocenciaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
