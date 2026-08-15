CREATE TABLE usuario (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         nome VARCHAR(150) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         email_verificado BOOLEAN NOT NULL DEFAULT FALSE,
                         criado_em TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE empresa_diretorio (
                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                   nome VARCHAR(150) NOT NULL,
                                   categoria VARCHAR(100),
                                   canal VARCHAR(20) NOT NULL CHECK (canal IN ('email_automatico', 'formulario_manual')),
                                   contato_ou_link TEXT NOT NULL,
                                   pais VARCHAR(100),
                                   instrucoes TEXT,
                                   criado_em TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE verificacao_vazamento (
                                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                       usuario_id UUID REFERENCES usuario(id) ON DELETE CASCADE,
                                       email_consultado VARCHAR(255) NOT NULL,
                                       resultado_json JSONB NOT NULL,
                                       verificado_em TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_verificacao_vazamento_usuario_id ON verificacao_vazamento(usuario_id);

CREATE TABLE solicitacao_remocao (
                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     usuario_id UUID NOT NULL REFERENCES usuario(id) ON DELETE CASCADE,
                                     empresa_id UUID NOT NULL REFERENCES empresa_diretorio(id) ON DELETE RESTRICT,
                                     canal_usado VARCHAR(20) NOT NULL CHECK (canal_usado IN ('email_automatico', 'formulario_manual')),
                                     status VARCHAR(20) NOT NULL DEFAULT 'pendente' CHECK (status IN ('pendente', 'enviado', 'concluido')),
                                     consentimento_confirmado BOOLEAN NOT NULL DEFAULT FALSE,
                                     data_envio TIMESTAMPTZ,
                                     observacoes TEXT,
                                     criado_em TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_solicitacao_remocao_usuario_id ON solicitacao_remocao(usuario_id);
CREATE INDEX idx_solicitacao_remocao_empresa_id ON solicitacao_remocao(empresa_id);