ALTER TABLE pacientes ADD ativo BOOLEAN;
UPDATE pacientes SET ativo = true;

ALTER TABLE pacientes
ALTER COLUMN ativo SET NOT NULL;